package com.wujie.mylistview.Bankcard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import com.wujie.mylistview.R;


@SuppressLint("AppCompatCustomView")
public class Myet extends EditText {
    StringBuilder sb = new StringBuilder();
    public Myet(Context context) {
        this(context, null);
    }

    public Myet(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributeSet(context, attrs);
    }

    public Myet(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttributeSet(context, attrs);
    }

    private void parseAttributeSet(Context context, AttributeSet attrs) {
        setSingleLine();
        addTextChangedListener(textWatcher);
    }
    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int bedore, int count) {


            String cardId=charSequence.toString();
            Log.d("wujie","长度："+cardId.length());

            if (start>5&&start<16){
                cardId=cardId.substring(start,start+1);
                Log.d("wujie","数据："+cardId);
                cardId = cardId.replace(cardId,"*");
                if (start==6||start==11){
                    sb.append(" ");
                }
                sb.append(cardId);
                Log.d("wujie", "onTextChanged: "+sb);

            }else {
                cardId=cardId.substring(start,start+1);
                if (start==16){
                    sb.append(" ");
                }
                sb.append(cardId);
            }
            removeTextChangedListener(textWatcher);
            setText(sb);
            setSelection(sb.length());
            addTextChangedListener(textWatcher);



//
        }

        @Override
        public void afterTextChanged(Editable editable) {


        }
    };
    public String getTextWithoutSpace() {
        return super.getText().toString().trim();
    }
}
