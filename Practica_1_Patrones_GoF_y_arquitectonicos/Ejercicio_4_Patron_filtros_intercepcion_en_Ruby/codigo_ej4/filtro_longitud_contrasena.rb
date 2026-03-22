# filtro_longitud_contrasena.rb

require_relative 'filtro'

class FiltroLongitudContrasena < Filtro

  LONGITUD_MINIMA = 8 # Como minimo 8 caracteres

  def ejecutar(credenciales)
    # Extraemos la contraseña de las credenciales
    contrasena = credenciales.contrasena

    # Comprobamos su longitud
    if contrasena.length < LONGITUD_MINIMA
      puts "ERROR. La contraseña introducida no es válida, es demasiado corta."
      puts "Necesita tener al menos #{LONGITUD_MINIMA} caracteres."
      puts "Ha fallado en el filtro 3 (Longitud de la contraseña)"
      return false
    end

    # Si ha pasado lo anterior, es que cumple con la longitud minima
    puts "Filtro 3 (Longitud de la contraseña) superado!"
    return true
  end

end

