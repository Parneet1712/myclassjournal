package edu.uc.cech.soit.myclassjournal;

import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import edu.uc.cech.soit.myclassjournal.service.IJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyClassJournalController {

    @Autowired
    IJournalService journalService;

    /**
     * Handle the / endpoint
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        JournalEntry journalEntry = new JournalEntry();
        journalEntry.setNotes("This is my first Journal");
        journalEntry.setDate("October 2020");
        model.addAttribute(journalEntry);

        return "start";
    }

    @RequestMapping("/saveJournalEntry")
    public String saveJournalEntry(JournalEntry journalEntry)   {
        try{
            journalService.save(journalEntry);
        }   catch (Exception e) {
            e.printStackTrace();
            return "start";
        }
        return "start";
    }


}
