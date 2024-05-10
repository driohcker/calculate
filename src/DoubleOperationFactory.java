interface DoubleOperationFactory { // 工厂接口
    public static DoubleOperation getResult(String operator) {
        DoubleOperation oper=null;
        switch(operator) {
            case"+":
                oper=new AddOperation();
                break;
            case"-":
                oper=new SubOperation();
                break;
            case"*":
                oper=new ChengOperation();
                break;
            case"/":
                oper=new ChuOperation();
                break;
        }
        return oper;
    }
}