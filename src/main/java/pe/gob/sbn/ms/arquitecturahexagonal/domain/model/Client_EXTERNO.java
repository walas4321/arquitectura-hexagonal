package pe.gob.sbn.ms.arquitecturahexagonal.domain.model;

public class Client_EXTERNO {

    private Long id;

    private String name;

    private String email;

    public Client_EXTERNO() {
    }

    public Client_EXTERNO(
            Long id,
            String name,
            String email
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /*
     * Getters and Setters
     */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


}
