package mx.mobilestudio.placefinder.model;

/**
 * Created by cesar on 8/5/17.
 */

public class ApiFourSquareResponse {
    private  Meta meta;
    private Response response;


    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }


}
