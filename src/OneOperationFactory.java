interface OneOperationFactory { // 工厂接口
    public static OneOperation getResult(String operator) {
        OneOperation oper=null;
        switch(operator) {
            case"||":
                oper=new JueduiOperation();
                break;
            case"√":
                oper=new PingfanggenOperation();
                break;
            case"-1":
                oper=new DaoshuOperation();
                break;

        }
        return oper;
    }
}