package com.wujie.mylistview;

import java.util.List;

/**
 * 实体类
 */
public class Bean {
  public  static  String name;
    /**
     * code : 200
     * result : [{"title":"工商银行卡","cardnum":"6212261907000087176","type":0},{"title":"农业银行卡","cardnum":"6212261907000087198","type":0},{"title":"招商银行卡","cardnum":"6212261907000087176","type":0},{"title":"亲属卡two","type":1},{"title":"亲属卡one","type":1},{"title":"亲属卡3","type":1}]
     */

    private int code;//返回码
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;

    }

    public static class ResultBean {
        /**
         * title : 工商银行卡
         * cardnum : 6212261907000087176
         * type : 0
         */

        private String title;
        private String cardnum;
        private int type;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCardnum() {
            return cardnum;
        }

        public void setCardnum(String cardnum) {
            this.cardnum = cardnum;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
