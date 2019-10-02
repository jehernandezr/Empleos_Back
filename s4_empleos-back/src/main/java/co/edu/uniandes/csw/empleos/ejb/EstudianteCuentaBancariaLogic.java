package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import co.edu.uniandes.csw.empleos.persistence.CuentaBancariaPersistence;
import co.edu.uniandes.csw.empleos.persistence.EstudiantePersistence;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EstudianteCuentaBancariaLogic {

    @Inject
    private EstudiantePersistence estudiantePersistence;

    @Inject
    private CuentaBancariaPersistence cuentaBancariaPersistence;
    
     /**
     * Remplazar la cuentaBancaria de un estudiante.
     *
     * @param calId .
     * @param estId .
     * @return .
     */
    public EstudianteEntity replaceCuentaBancaria(Long estId, Long cuentaId) {
        CuentaBancariaEntity cuentaBancariaEntity = cuentaBancariaPersistence.find(cuentaId);
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estId);
        estudianteEntity.setCuentaBancaria(cuentaBancariaEntity);
        return estudianteEntity;
    }
    
    
    
    /**
     * Borrar una cuentaBancaria de un Estudiante Este metodo se utiliza para borrar la
     * relacion de una cuentaBancaria.
     *
     * @param calId El libro que se desea borrar de la editorial.
     */
    public void removeCuentaBancaria(Long estId) {
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estId);
        CuentaBancariaEntity cuentaBancariaEntity = cuentaBancariaPersistence.find(estudianteEntity.getCuentaBancaria().getId());
        estudianteEntity.setCuentaBancaria(null);
        cuentaBancariaEntity.setEstudiante(null);
    }
    

    
    

}
