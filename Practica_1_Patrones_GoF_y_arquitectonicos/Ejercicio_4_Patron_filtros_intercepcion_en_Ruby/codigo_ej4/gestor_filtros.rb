# gestor_filtros.rb

require_relative 'cadena_filtros'

class GestorFiltros

  def initialize(objetivo)
    # Creamos la cadena de filtros
    @cadena_filtros = CadenaFiltros.new

    # Asignamos el objetivo a la cadena de filtros
    @cadena_filtros.aniadir_objetivo(objetivo)
  end

  def aniadir_filtro(filtro)
    @cadena_filtros.aniadir_filtro(filtro)
  end

  # Se realiza una petición pasandole las credenciales para comprobar si pasan los filtros
  def peticion(credenciales)
    @cadena_filtros.ejecutar(credenciales)
  end
end
