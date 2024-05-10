public class ChuFactory  implements DoubleOperationFactory { // 表示除法类工厂
    public DoubleOperation createOperation() {
        return new ChuOperation();
    }
}