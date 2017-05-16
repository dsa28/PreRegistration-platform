/**
 * Created by mahmoudsafar on 5/16/17.
 */
public enum RequestState {

    Pending(0),
    Approved(1),
    Rejected(2);

    private int num;

    RequestState(int num)
    {
        this.num = num;
    }


}
