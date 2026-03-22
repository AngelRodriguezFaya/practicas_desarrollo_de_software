# cadena_filtros.rb

require_relative 'filtro'
require_relative 'objetivo'

class CadenaFiltros

  # Constructor
  def initialize
    @array_filtros=[]     # Array de filtros a ejecutar para alzanzar objetivo
    @objetivo=nil   # Objetivo a alcanzar tras pasar los filtros
  end

  def aniadir_filtro(filtro)
    @array_filtros << filtro
  end

  def aniadir_objetivo(objetivo)
    @objetivo = objetivo
  end

  def ejecutar(credenciales)
    @array_filtros.each do |filtro| # Es un bucle for-each
      resultado = filtro.ejecutar(credenciales)

      # Ahora compruebo el resultado de aplicar el filtro.
      # Si es true entonces lo ha pasado. Si es false no lo ha pasado y por tanto terminamos
      if resultado == false
        return
      end
    end

    if !@objetivo.nil? # Equivalente a if (objetivo != null)
      @objetivo.imprimir_objetivo
    else
      puts "Se han pasado los filtros correctamente, pero no hay un objetivo (target) establecido."
    end

  end

end
