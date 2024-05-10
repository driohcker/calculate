public class SubFactory implements DoubleOperationFactory { // 表示减法类工厂
    public DoubleOperation createOperation() {
        return new SubOperation();
    }
}