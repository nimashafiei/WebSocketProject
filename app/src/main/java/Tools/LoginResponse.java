package Tools;


import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private DataResult data;

    public DataResult getData() {
        return data;
    }

    public void setData(DataResult data) {
        this.data = data;
    }

    public void setMessage(String res){
        this.message = res;
    }

    public String getMessage() {
        return message;
    }

    public class DataResult{

        @SerializedName("token")
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
