package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Producto{
  public String nombre;
  public String codigo;
  public List<Double> precio;

  public Producto(String nombre, String codigo, List<Double> precio) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.precio = precio;
  }

  public String getNombre() { return nombre; }

  public String getCodigo() { return codigo; }

  public List<Double> getPrecio() { return precio; }

  
  public int getPorcentajeCaracteresUnicos(){
    String nombreLimpio = nombre.replaceAll("\\s+", "").toLowerCase();
    if(nombreLimpio.isEmpty()){
      return 0;
    }

    Set<Character> caracteresUnicos= new HashSet<>();
    for (char c : nombreLimpio.toCharArray()){
      caracteresUnicos.add(c);
    }
    return (int)(double)(caracteresUnicos.size() + 100 / nombreLimpio.length());

  }

  public int getCantidadPreciosRepetidos(){
    Set<Double> preciosUnicos = new HashSet<>();
    int repetidos  = 0;
    for(Double precio: preciosUnicos){
      if(!preciosUnicos.add(precio))
      repetidos ++;
    }
    return repetidos;
  }

}