# main.rb

require_relative 'credenciales'
require_relative 'gestor_filtros'
require_relative 'filtro'
require_relative 'filtro_prefijo_correo'
require_relative 'filtro_dominio_correo'
require_relative 'filtro_longitud_contrasena'
require_relative 'filtro_espacios_contrasena'
require_relative 'filtro_diferencia_contrasena'
require_relative 'objetivo'

# Pedimos al usuario que introduzca su correo y contraseña
puts "====================================================="
print "Introduzca su correo: "
correo_usuario = gets.chomp # Con chomp ingonra el salto de línea '\n'

print "Introduzca su contraseña: "
contrasena = gets.chomp

puts "El correo introducido es #{correo_usuario}. \n\n"

# Definimos las credenciales
credenciales = Credenciales.new(correo_usuario, contrasena)

# Creamos el gestor de filtros y el objetivo
objetivo = Objetivo.new
gestor_filtros = GestorFiltros.new(objetivo)

# Añadimos los filtros
gestor_filtros.aniadir_filtro(FiltroPrefijoCorreo.new)
gestor_filtros.aniadir_filtro(FiltroDominioCorreo.new)
gestor_filtros.aniadir_filtro(FiltroLongitudContrasena.new)
gestor_filtros.aniadir_filtro(FiltroEspaciosContrasena.new)
gestor_filtros.aniadir_filtro(FiltroDiferenciaContrasena.new)

# Ahora le indicamos al gestor de filtros que haga una petición de ejecución
# a los filtros con las credenciales pasadas como parámetro
gestor_filtros.peticion(credenciales)

puts "====================================================="

