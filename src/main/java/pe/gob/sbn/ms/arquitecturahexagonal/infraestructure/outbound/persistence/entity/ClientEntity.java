package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.enums.ClientStatus;

import java.time.LocalDate;

@Entity
@Table(name = "clients")
@RequiredArgsConstructor
@Data
@Setter
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate fechNac;

    @Column(nullable = false)
    private ClientStatus estado;

}
