package br.luiz.contato.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.luiz.contato.entity.Contato;
import br.luiz.contato.repository.ContatoRepository;
import br.luiz.contato.service.ContatoService;

@Controller
//@RequestMapping("/contato")
public class ContatoController {
   
  @Autowired
  private ContatoService service;
   
  @RequestMapping(value="/contato", method = RequestMethod.GET)
  public String listar(@RequestParam(value="search", required = false) String search, Model model) {
	  List<Contato> lista = null;  
		if (search !=  null)
		{
			lista = service.findBySearch(search);
		 }	
		else 
		{
			lista = service.findBySearch("");
         }
      model.addAttribute("search", lista);
      return "contato";
  }
  
  @RequestMapping(value = "/contato/novo", method = RequestMethod.GET)
  public String novo(Model model) {	  
	  Contato contato = new Contato();
	  model.addAttribute("contato", contato);
      return "novo";
  }
  
  @RequestMapping(value = "/contato/save", method = RequestMethod.POST)
  public String saveContato(@ModelAttribute("contato") Contato contato) {
	  SimpleDateFormat formaDate = new SimpleDateFormat("dd/MM/yyyy");
      String data = formaDate.format(contato.getData());	  
      try {
		contato.setData(formaDate.parse(data));
	  } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
      service.save(contato);       
      return "redirect:/contato";
  }
  
  @RequestMapping("/contato/edit/{id}")
  public ModelAndView showEditContatoPage(@PathVariable(name = "id") long id) {
      ModelAndView mav = new ModelAndView("edit");
      Contato contato = service.get(id);
      mav.addObject("contato", contato);
       
      return mav;
  }
  
  @RequestMapping("/contato/delete/{id}")
  public String DeleteContato(@PathVariable(name = "id") long id) {
      //ModelAndView mav = new ModelAndView("edit");
      service.delete(id);
      return "redirect:/contato";
  }
}