package com.example.clase2.controller;
import com.example.clase2.entity.Shipper;
import com.example.clase2.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shipper")
public class ShipperController {
    @Autowired
    ShipperRepository shipperRepository;

    @GetMapping(value = {"","/lista"})
    public String listaShippers(Model model){
        List<Shipper> listaShippers = shipperRepository.findAll();
        model.addAttribute("lista", listaShippers);
        return "shipper/lista";
    }

    @PostMapping(value = "/buscarTransportista")
    public String buscarshipper(@RequestParam("searchfield") String searchfield, Model model){
        List<Shipper> listaShippers = shipperRepository.findByCompanyname(searchfield);
        model.addAttribute("lista",listaShippers);
        return "shipper/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoTranspoortista(){
    return "shipper/formulario";
    }

    @PostMapping("/guardar")
    public String guardarShipper(Shipper shipper,
                                 RedirectAttributes attr){
        if(shipper.getShipperid() !=0){
            attr.addFlashAttribute("msg","Transportista actualizado exitosamente");
        }else{
            attr.addFlashAttribute("msg","Transportista creado exitosamente");
        }
        shipperRepository.save(shipper);
        return "redirect:/shipper";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") int id, Model model){
        Optional<Shipper> opt = shipperRepository.findById(id);
        if( opt.isPresent()){
            Shipper shipper = opt.get();
            model.addAttribute("shipper", shipper);
            return "shipper/editar";
        }else{
            return "redirect:/shipper";
        }

    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id){
        Optional<Shipper> opt = shipperRepository.findById(id);
        if(opt.isPresent()){
            shipperRepository.deleteById(id);
        }
        return "redirect:/shipper";
    }
}
