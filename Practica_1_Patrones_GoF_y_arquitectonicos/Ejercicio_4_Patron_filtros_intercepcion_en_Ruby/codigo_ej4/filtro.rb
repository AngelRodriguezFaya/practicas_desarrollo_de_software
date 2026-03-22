# filtro.rb

class Filtro

  # Metodo abstracto
  def ejecutar(credenciales)
    raise NotImplementedError, "Las subclases que implementen la interfaz filtro deben implementar este método"
  end

end
