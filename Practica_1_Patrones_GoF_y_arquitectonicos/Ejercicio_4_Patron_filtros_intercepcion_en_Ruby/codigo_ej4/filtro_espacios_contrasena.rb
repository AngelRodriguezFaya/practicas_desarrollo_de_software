# filro_espacios_contrasena.rb

require_relative 'filtro'

class FiltroEspaciosContrasena < Filtro

  def ejecutar(credenciales)
    # Extraemos la contraseña de las credenciales
    contrasena = credenciales.contrasena

    #COmprobamos si tiene espacios
    if !contrasena.include?(" ")
      puts "Filtro 4 (Espacios en la contraseña) superado!"
      return true
    else # Si incluye espacios en blanco no es válida
      puts "ERROR. La contraseña introducida no es válida porque tiene espacio(s)"
      puts "Ha fallado en el filtro 4 (Espacios en la contraseña)"
      return false
    end


  end

end

