public class AddFactory implements DoubleOperationFactory { // 表示加法类工厂
    public DoubleOperation createOperation() {
        return new AddOperation();
    }

}