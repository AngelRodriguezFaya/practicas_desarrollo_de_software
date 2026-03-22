# filtro_prefijo_correo.rb

# importamos la interfaz filtro
require_relative 'filtro'

class FiltroPrefijoCorreo < Filtro

  def ejecutar(credenciales)
    # Obtenemos el correo de las credenciales
    correo = credenciales.correo

    # Separamos el texto en dos, partiendo por donde está la @
    # y nos quedamos con el primer trozo (lo que tenemos a la izquierda)
    prefijo = correo.split('@').first

    # Ahora comprobamos que hay en el prefijo
    # Si no hay @ o no hay nada antes de ella, el prefijo deberá de estar vacío
    if prefijo.nil? || prefijo.empty? # nil mira si es null, y empty si existe pero esta vacio
      puts "ERROR. El correo introducido no es válido."
      puts "Ha fallado en el filtro 1 (Prefijo del correo)"
      return false # Terminamos
    end

    # Si ha pasado el condicional anterior, es que si hay texto
    # En ese caso, lo mostramos
    puts "Filtro 1 (Prefijo del correo) superado!"
    return true

  end

end