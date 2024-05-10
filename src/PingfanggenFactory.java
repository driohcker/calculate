public class PingfanggenFactory implements OneOperationFactory{
    public  OneOperation createOperation(){
        return new PingfanggenOperation();
    }
}
