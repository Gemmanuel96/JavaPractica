package Entities;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Base {
    private Long id;
    private boolean eliminado;
    private LocalDate createAd;

    public Base(Long id) {
        this.id = id;
        this.eliminado = false;
        this.createAd = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDate getCreateAd() {
        return createAd;
    }

    public void setCreateAd(LocalDate createAd) {
        this.createAd = createAd;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
//                ", eliminado=" + eliminado +
//                ", createAd=" + createAd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return eliminado == base.eliminado && Objects.equals(id, base.id) && Objects.equals(createAd, base.createAd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eliminado, createAd);
    }
}
