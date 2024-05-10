public class ChengFactory implements DoubleOperationFactory { // 表示乘法类工厂
    public DoubleOperation createOperation() {
        return new ChengOperation();
    }
}