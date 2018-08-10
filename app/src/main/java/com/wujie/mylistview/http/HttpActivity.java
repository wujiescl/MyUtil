package com.wujie.mylistview.http;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wujie.mylistview.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HttpActivity extends AppCompatActivity {
private Button btn;
private TextView textView;

    private Handler hanlder=new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    String qq= (String) msg.obj;
                    textView.setText("服务器返回: " + qq);

                    break;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        btn=findViewById(R.id.btn_getdata);
        textView=findViewById(R.id.tv_data);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdata();
            }
        });
    }

    public void  getdata(){
        new Thread() {
            @Override
            public void run() {
                String url="http://10.9.69.34:8080/Wujie/TestServlet";//服务器接口地址
                try
                {

                    JSONObject jsonObject=new JSONObject();
                    JSONObject jsonObject1=new JSONObject();
                    jsonObject1.put("appId","2111111111");
                    jsonObject1.put("Rmk","2222222");
                    jsonObject.put("isSkip","true");
                    jsonObject.put("request",jsonObject1);
                    String jsonstring = jsonObject.toString();
                    Log.d("wujie","网络请求发送数据："+jsonstring);

                    NameValuePair pair1 = new BasicNameValuePair("", jsonstring);
                    List<NameValuePair> pairList = new ArrayList<NameValuePair>();
                    pairList.add(pair1);

                    Log.d("wujie","网络请求");
                    HttpEntity requestHttpEntity = new UrlEncodedFormEntity(
                            pairList);
                    // URl是接口地址
                    HttpPost httpPost = new HttpPost(url);
                    // 将请求体内容加入请求中
                    httpPost.setEntity(requestHttpEntity);
                    // 需要客户端对象来发送请求
                    HttpClient httpClient = new DefaultHttpClient();
                    // 发送请求
                    HttpResponse response = httpClient.execute(httpPost);
                    // 显示响应
                    Log.d("wujie","网络请求结果："+  response.getStatusLine().getStatusCode());

                    showResponseResult(response);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }



            }
        }.start();
    }

    /**
     * 显示响应结果到命令行和TextView
     * @param response
     */
    private void showResponseResult(HttpResponse response)
    {
        Log.d("wujie","网络请求完毕");
        if (null == response)
        {
            return;
        }

        HttpEntity httpEntity = response.getEntity();
        try
        {
            InputStream inputStream = httpEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));
            String result1 = "";
            String line = "";
            while (null != (line = reader.readLine()))
            {
                result1 += line;

            }

            System.out.println(result1);
            /**
             * 把服务器返回的结果 发送到hanlder中，在子线程中是不允许更新ui的
             */
            hanlder.obtainMessage(0,result1).sendToTarget();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
