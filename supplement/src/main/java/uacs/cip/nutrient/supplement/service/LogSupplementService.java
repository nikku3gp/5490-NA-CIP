package uacs.cip.nutrient.supplement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacs.cip.nutrient.supplement.entity.LogSupplement;
import uacs.cip.nutrient.supplement.repositoty.LogSupplementRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LogSupplementService {
    @Autowired
    private LogSupplementRepository logSupplementRepository;

    public List<LogSupplement> getAllLogs(){
        return logSupplementRepository.findAll();
    }

    public Optional<LogSupplement> getLog(Long id){
        return logSupplementRepository.findById(id);
    }

    public List<LogSupplement> getLogByDate(LocalDate date){
        return logSupplementRepository.findByDate(date);
    }

    public List<LogSupplement> getLogByDateRange(LocalDate start, LocalDate end){
        return logSupplementRepository.findByDateBetween(start, end);
    }

    public LogSupplement saveLog(LogSupplement logSupplement){
        return logSupplementRepository.save(logSupplement);
    }

    public void deleteLog(Long id){
        logSupplementRepository.deleteById(id);
    }

}
