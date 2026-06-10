package pe.gob.sbn.ms.arquitecturahexagonal.domain.model;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.enums.ClientStatus;

import java.time.LocalDate;

public class Client {

    private Long id;

    private String name;

    private String lastName;

    private String adress;

    private String email;

    private String phoneNumber;

    private LocalDate fechNac;

    private ClientStatus estado;

    public Client(){
    }

    public Client(
            Long id,
            String name,
            String lastName,
            String adress,
            String email,
            String phoneNumber,
            LocalDate fechNac,
            ClientStatus estado
    ) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fechNac = fechNac;
        this.estado = estado;
    }

     /* Business logic methods */

     public void activate(){
         if(this.estado == ClientStatus.ACTIVE){
             throw new IllegalStateException("Client is already active");
         }
         this.estado = ClientStatus.ACTIVE;
     }

     public void deactivate(){
         if(this.estado == ClientStatus.INACTIVE){
             throw new IllegalStateException("Client is already inactive");
         }
         this.estado = ClientStatus.INACTIVE;
     }

     public void suspend(){
         if(this.estado == ClientStatus.SUSPENDED){
             throw new IllegalStateException("Client is already suspended");
         }
         this.estado = ClientStatus.SUSPENDED;
     }

    /*
     * Getters and Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
     public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress){
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public void setFechNac(LocalDate fechNac){
        this.fechNac = fechNac;
    }

    public ClientStatus getEstado() {
        return estado;
    }

    public void setEstado(ClientStatus estado){
        this.estado = estado;
    }


}
