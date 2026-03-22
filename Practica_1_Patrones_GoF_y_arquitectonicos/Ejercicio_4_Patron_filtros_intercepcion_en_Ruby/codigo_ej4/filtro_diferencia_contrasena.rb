# filtro_diferencia_contrasena.rb

require_relative 'filtro'

class FiltroDiferenciaContrasena < Filtro

  def ejecutar(credenciales)
    # Necesitamos extraer el correo y la contraseña de las credenciales
    correo = credenciales.correo
    contrasena = credenciales.contrasena

    # Extraemos el prefijo del correo
    prefijo = correo.split('@').first

    # Ahora comprobamos que el prefijo del correo y la contraseña no sean iguales
    if prefijo != contrasena
      puts "Filtro 5 (Diferencia de la contraseña) superado!"
      return true
    else
      puts "ERROR. La contraseña introducida no es válida, es igual que el correo introducido"
      puts "Ha fallado en el filtro 5 (Diferencia de la contraseña)"
      return false
    end
  end
end

