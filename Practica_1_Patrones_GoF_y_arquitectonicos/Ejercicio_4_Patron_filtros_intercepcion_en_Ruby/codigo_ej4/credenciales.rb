# credenciales.rb

class Credenciales

  # Consultores y modificadores
  attr_accessor :correo, :contrasena

  # Constructor
  def initialize(correo, contrasena)
    @correo = correo
    @contrasena = contrasena
  end
end