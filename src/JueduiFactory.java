public class JueduiFactory implements OneOperationFactory{
    public  OneOperation createOperation(){
        return new JueduiOperation();
    }
}