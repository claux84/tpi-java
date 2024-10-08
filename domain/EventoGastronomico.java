package ar.com.eventos.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;



public class EventoGastronomico {
    private int id;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaYHora;
    private String ubicacion;
    private int capacidad;
    private Cheff cheff;
    private List<Resenia> resenias = new ArrayList<>();
    private Map<Integer , Participante> participantes = new TreeMap<>();

    public EventoGastronomico( String nombre, String descripcion, LocalDateTime fechaYHora, String ubicacion, int capacidad, Cheff cheff, List<Resenia> resenias, Map<Integer, Participante> participantes){
        setId();
        setNombre(nombre);
        setDescripcion(descripcion);
        setFechaYHora(fechaYHora);
        setUbicacion(ubicacion);
        setCapacidad(capacidad);
        setCheff(cheff);
        setResenias(resenias);
        setParticipantes(participantes); 
    }

    public EventoGastronomico(){
        setId();
    }


    public void setId() {
        this.id = atomicInteger.incrementAndGet();
    }

    public int getId() {
        return id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCheff(Cheff cheff) {
        this.cheff = cheff;
    }
    public Cheff getCheff() {
        return cheff;
    }

    public void setResenias(List<Resenia> resenias) {
        this.resenias = resenias;
    }

    public List<Resenia> getResenias() {
        return resenias;
    }

    public void setParticipantes(Map<Integer, Participante> participantes) {
        this.participantes = participantes;
    }

    public Map<Integer, Participante> getParticipantes() {
        return participantes;
    }


    public int cantidadDeParticipantes(){
        int cantidadDeParticipantes = this.participantes.size();
        return cantidadDeParticipantes;
    }

    public int cantidadDeResenias(){
        int cantidadDeResenias = this.resenias.size();
        return cantidadDeResenias;
    }

    public String cheffToString(){
        String nombreYApellido = null;
        if (this.cheff != null) {
            nombreYApellido = this.cheff.getNombre() + " " + this.cheff.getApellido();
        } else {
            nombreYApellido = " No hay cheff asignado ";
            
        }
        return nombreYApellido;
    }

    @Override
    public String toString(){
        return  "ID: " + this.id
                + " Nombre : " + this.nombre
                + " Descripción: " + this.descripcion
                + " Fecha y Hora : " + this.fechaYHora
                + " Ubicación : " + this.ubicacion
                + " Capacidad: " + this.capacidad
                + " Cheff a cargo: " + this.cheffToString()
                + " Cantidad de participantes inscriptos: " + this.cantidadDeParticipantes()
                + " Cantidad de reseñas del evento : " + this.cantidadDeResenias();
    }

    

}