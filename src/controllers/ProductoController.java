package controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import models.Producto;

public class ProductoController {

  public TreeSet<Producto> ordenarProducto(List<Producto> productos){
    return new TreeSet<>(productos);
  }

  public Map<String, List<Producto>> clasificarPorUnicidad (Set<Producto> productos){
    Map<String, List<Producto>> calificacion = new LinkedHashMap<>();
    calificacion.put("A", new LinkedList<>());
    calificacion.put("B", new LinkedList<>());
    calificacion.put("C", new LinkedList<>());
    calificacion.put("D", new LinkedList<>());
    calificacion.put("E", new LinkedList<>());

    for(Producto producto : productos){
      double procentaje = producto.getPorcentajeCaracteresUnicos();

      if (porcentaje >= 90 && porcentaje <= 100){
        calificacion.get("A").add(producto);
      }else if (porcentaje >=70 && porcentaje <=89){
        calificacion.get("B").add(producto);
      }else if (porcentaje >=50 && porcentaje <=69){
        calificacion.get("C").add(producto);
      }else if (porcentaje >=30 && porcentaje <=49){
        calificacion.get("D").add(producto);
      }else{
        calificacion.get("E").add(producto);
      }
      return calificacion;
    }
  }
  
  public List<Producto> obtenerDestacados(List<Producto> productos){

    return productos.stream().filter(p -> p.getCantidadPreciosRepetidos() > 1).sorted(Comparator.comparing(Producto :: getNombre)).collect(Collectors.toList());
  }

  public Producto buscarPorNombre(List<Producto> lista, String nombre){
    Collections.sort(lista, Comparator.comparing(Producto :: getNombre));

    int inicio = 0;
    int fin = lista.size() -1;

    while (inicio <= fin ){
      int medio = inicio + (fin - inicio)/2;
      int comparacion = lista.get(medio).getNombre().compareTo(nombre);

      if (comparacion == 0){
        return lista.get(medio);
      }if (comparacion < 0){
        inicio = medio + 1;
      }else{
        fin = medio -1;
      }
    }
    return null;
  }
  
}
