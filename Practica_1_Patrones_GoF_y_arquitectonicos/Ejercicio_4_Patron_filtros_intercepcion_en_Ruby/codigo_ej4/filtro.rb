# filtro.rb

class Filtro # Es una interfaz

  # Metodo abstracto
  def ejecutar(credenciales)
    raise NotImplementedError, "Las subclases que implementen la interfaz filtro deben implementar este método"
  end

end
