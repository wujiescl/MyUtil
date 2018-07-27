package com.wujie.mylistview.pop2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wujie.mylistview.R;

import java.util.List;


/**
 * @author Choklongchen
 * <p>
 * 原创详情页中 点击右下角按钮  弹出第一层展示框
 */
public class ChoosePayBankPopupWindow extends PopupWindow {

    private Activity context;
    private View mMenuView;
    RelativeLayout rl_money,rl_add_newcard;
    MyListView lv_navlist;
    List<PayType> mData;
    LinearLayout ly_navlist_show;
    CheckBox checkBox1,checkBox2;
    OnItemClickListener onCheckboxItemClickListener;
    /**
     * @param context
     */
    public ChoosePayBankPopupWindow(Activity context, List<PayType> listData, OnItemClickListener onCheckboxItemClickListener) {
        super(context);
        init(context, listData, onCheckboxItemClickListener);
    }

    private void init(Activity context, final List<PayType> data, OnItemClickListener onItemClickListener) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.fastnav_list_popudialog, null);

        lv_navlist = (MyListView) mMenuView.findViewById(R.id.lv_navlist);

        ly_navlist_show = (LinearLayout) mMenuView.findViewById(R.id.ly_navlist_show);
        rl_money= (RelativeLayout) mMenuView.findViewById(R.id.rl_money);
        rl_add_newcard= (RelativeLayout) mMenuView.findViewById(R.id.add_new_card);
        checkBox1= (CheckBox) mMenuView.findViewById(R.id.cb_money_choose);
        checkBox2= (CheckBox) mMenuView.findViewById(R.id.cb_add_newbank);

        this.mData = data;
        this.onCheckboxItemClickListener = onItemClickListener;
        this.setContentView(mMenuView);
        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.ActionSheetDialogAnimation);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        this.setBackgroundDrawable(dw);


        if (Contact.ADD_NEW_CARD){
            checkBox2.setBackgroundResource(R.drawable.icon_choose_checked);
        }else {
            checkBox2.setBackgroundResource(R.drawable.icon_choose_normal);
        }

        if (Contact.CHOOSE_MONET){
            checkBox1.setBackgroundResource(R.drawable.icon_choose_checked);
        }else {
            checkBox1.setBackgroundResource(R.drawable.icon_choose_normal);
        }
        rl_money.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxItemClickListener.onMoneyClick();
                dismiss();
            }
        });

        rl_add_newcard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxItemClickListener.onAddCardClick();
                dismiss();
            }
        });

        mMenuView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                ListView lsit_view = (ListView) mMenuView.findViewById(R.id.lv_navlist);


                int[] position = new int[2];
                lsit_view.getLocationInWindow(position);
                int height = Math.abs(position[1]);
                int y = (int) event.getY();

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
        resetViewHeight(context, mData, ly_navlist_show);
        initshopListShow(mData, context);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    ///  46item   93otherview

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    public static int getScreenHeightByPix(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * Author choklongchen
     *
     * @param
     * @return true  代表返回的滑动位置在屏幕中线以下  返回false  在之上
     */
    public static void resetViewHeight(Context context, List<PayType> mData, View needChangeView) {
        Display display;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();

        int maxScreenHeght = display.getHeight() * 1/ 2;
        if (mData.size() > 4) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, maxScreenHeght);
            needChangeView.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            needChangeView.setLayoutParams(layoutParams);
        }


    }

    class BuyListAdapter extends BaseAdapter {
        Context context;
        LayoutInflater mInflater;

        BuyListAdapter(Context context){
            this.context=context;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mData != null && mData.size() > 0 ? mData.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            PayType payType = mData.get(position);
            ViewHolder viewHolder=null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fastnav_click_item, null);
                viewHolder=new ViewHolder();
                viewHolder.tv_bank_name = (TextView) convertView.findViewById(R.id.tv_bank_name);
                viewHolder.tv_bank_detail = (TextView) convertView.findViewById(R.id.tv_bank_detail);
                viewHolder.cb_bank_choose = (CheckBox) convertView.findViewById(R.id.cb_bank_choose);
                viewHolder.iv_logo= (ImageView) convertView.findViewById(R.id.logo);
                convertView.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }

            String bankName = payType.getBankName();
            if ("工商银行".equals(bankName)){
                viewHolder.iv_logo.setBackgroundResource(R.drawable.bank_icon_s_zhongyin);
            }else {
                viewHolder.iv_logo.setBackgroundResource(R.mipmap.ic_launcher);
            }
            String bankDetail = payType.getBankDetail();
            boolean choose = payType.isChoose();

            if (!TextUtils.isEmpty(bankName)) {
                viewHolder.tv_bank_name.setText(bankName);
                viewHolder.tv_bank_detail.setText(bankDetail);
                if (choose){
                    viewHolder.cb_bank_choose.setBackgroundResource(R.drawable.icon_choose_checked);

                }else {
                    viewHolder.cb_bank_choose.setBackgroundResource(R.drawable.icon_choose_normal);

                }
            }
            return convertView;
        }
    }

     class ViewHolder {
        TextView tv_bank_name;
        TextView tv_bank_detail;
        CheckBox cb_bank_choose;
        ImageView iv_logo;
    }

    /**
     * 设置弹框出现的时候背景变暗
     */
    private void setParentView() {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = 0.5f;
        context.getWindow().setAttributes(lp);
        this.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = context.getWindow().getAttributes();
                lp.alpha = 1f;
                context.getWindow().setAttributes(lp);
            }
        });
    }

    /**
     * 内部定义show方法，控制显示的时候背景变暗
     *
     * @param mainView
     * @param context
     */
    public void show(View mainView, Context context) {
        showAtLocation(mainView, Gravity.BOTTOM
                | Gravity.CENTER_HORIZONTAL, 0, 0);
        setParentView();
    }


    /**
     * 初始化底部弹出框内数据
     *
     * @param list_cellbean
     * @param activity
     */
    void initshopListShow(List<PayType> list_cellbean, Activity activity) {
        if (null != list_cellbean) {
            lv_navlist.setAdapter(new BuyListAdapter(activity));
            lv_navlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    onCheckboxItemClickListener.onItemClick(position);
                    dismiss();
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int which);

        void onAddCardClick();

        void onMoneyClick();

    }
}
