package nl.hu.v2tosad.data.model;

public class Database {
    private String name;
    private String db_type;
    private String db_url;
    private String db_user;
    private String db_pass;
    private String db_driv;

    public Database(String name, String db_type, String db_url, String db_user, String db_pass, String db_driv) {
        this.name = name;
        this.db_type = db_type;
        this.db_url = db_url;
        this.db_user = db_user;
        this.db_pass = db_pass;
        this.db_driv = db_driv;
    }

    public String getDb_pass() {
        return db_pass;
    }

    public String getName() {
        return name;
    }

    public String getDb_type() {
        return db_type;
    }

    public String getDb_url() {
        return db_url;
    }

    public String getDb_user() {
        return db_user;
    }

    public String getDb_driv() {
        return db_driv;
    }
}
