package test.adapters.dto;

public class PersonneDTO {
    private String nom;
    private String prenom;
    private String naissance;
    private Integer age;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
