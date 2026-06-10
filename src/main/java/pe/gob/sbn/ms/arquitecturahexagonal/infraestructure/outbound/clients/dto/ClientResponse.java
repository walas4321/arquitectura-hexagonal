package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.clients.dto;

public class ClientResponse {

    private Long id;

    private String name;

    private String email;

    public ClientResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
