public enum StatusResponse {

    SUCCESS("Success"),
    ERROR ("Error");

    private String status;

    StatusResponse(String success){

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}