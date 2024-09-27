//package org.spotify.validate;
//
//import org.spotify.db.dao.PerformerDao;
//import org.spotify.entities.Performer;
//import org.spotify.exceptions.NameIsBusyException;
//import org.spotify.exceptions.PerformerNotFoundException;
//
//import java.util.Optional;
//
//public class PerformerValidate {
//    private final PerformerDao performerDao = new PerformerDao();
//
//    public void validatePerformerName(String name) {
//        Optional<Performer> performer = performerDao.findPerformerByName(name);
//        if (performer != null) {
//            throw new NameIsBusyException("Name = %s is busy".formatted(name));
//        }
//    }
//
//    public void validatePerformer(String name) {
//        Optional<Performer> performer = performerDao.findPerformerByName(name);
//        if (performer != null) {
//            throw new PerformerNotFoundException("Performer with name = %s not found".formatted(name));
//        }
//    }
//}
