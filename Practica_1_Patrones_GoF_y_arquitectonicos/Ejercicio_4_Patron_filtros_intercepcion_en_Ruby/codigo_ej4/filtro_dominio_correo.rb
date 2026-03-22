#filtro_dominio_correo.rb

require_relative 'filtro'

class FiltroDominioCorreo < Filtro

  # Constante
  DOMINIOS_VALIDOS = %w[gmail.com hotmail.com]

  def ejecutar(credenciales)
    # Primero obtenemos el correo de las credenciales
    correo = credenciales.correo

    # Aseguramos que el cliente ha introducido la @ en el correo
    # Esto es necesario para el resto de la implementación
    if !correo.include?('@')
      puts "ERROR. El correo introducido no es válido. No contiene la '@'"
      puts "Ha fallado en el filtro 2 (Dominio del correo)"
      return false
    end

    # Ahora separamos el correo por donde la @ y nos quedamos con la
    # parte de la derecha
    dominio = correo.split('@').last

    # Comprobamos si el dominio es válido
    if DOMINIOS_VALIDOS.include?(dominio)
      puts "Filtro 2 (Dominio del correo) superado!"
      return true
    else
      puts "ERROR. El correo introducido no tiene un dominio válido"
      puts "Ha fallado en el filtro 2 (Dominio del correo)"
      return false
    end


  end
end