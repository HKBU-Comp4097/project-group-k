package hk.edu.hkbu.comp.hkbumapnavigated;

public class HKBUDepartment {
    private String name;
    private String website;
    private String email;
    private String telephone;

    public HKBUDepartment(String name, String website, String email, String telephone) {
        this.name = name;
        this.website = website;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

}