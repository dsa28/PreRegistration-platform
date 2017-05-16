/**
 * Created by mahmoudsafar on 5/16/17.
 */
public enum RequestState {

    Pending("Pending"),
    Approved("Approved"),
    Rejected("Rejected");

    private String state;

    RequestState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }


}
