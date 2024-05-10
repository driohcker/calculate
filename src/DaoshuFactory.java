public class DaoshuFactory implements OneOperationFactory{
    public  OneOperation createOperation(){
        return new DaoshuOperation();
    }
}
