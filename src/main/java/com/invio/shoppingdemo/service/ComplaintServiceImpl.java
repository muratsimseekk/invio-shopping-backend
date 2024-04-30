package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.entity.Complaint;
import com.invio.shoppingdemo.exceptions.CommonException;
import com.invio.shoppingdemo.repository.ComplaintRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ComplaintServiceImpl implements ComplaintService{

    private ComplaintRepository complaintRepository;
    @Override
    public String  save(String complaint) {

        Complaint complaint1 = new Complaint();

        complaint1.setComplaintText(complaint);

        complaintRepository.save(complaint1);

        return "Sikayetiniz kaydedildi . Icerik : "+complaint;
    }

    @Override
    public List<Complaint> findAll() {
        return complaintRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        Optional<Complaint> optional = complaintRepository.findById(id);

        if (optional.isPresent()){
            complaintRepository.delete(optional.get());
            return "Sikayet basari ile silindi.";
        }

        throw new CommonException("Ilgili id de Sikayet bulunamadi . ID:" +id, HttpStatus.NOT_FOUND);
    }
}
