package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



@RestController
@RequestMapping("/api")
public class LearningDiaryController {

    @Autowired
    private TopicRepository topicRepository;

    @CrossOrigin
    @GetMapping
    @RequestMapping("/topic")
    public Iterable<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("topic/{id}")
    public Optional<Topic> getTopicByID(@PathVariable Integer id) {
        return topicRepository.findById(id);
    }

    @PostMapping("/topic")
    Object addnewTopic(@RequestBody Topic t) {
        return topicRepository.save(t);
    }

    @DeleteMapping("topic/{id}")
    public void deleteTopic(@PathVariable Integer id) {
        topicRepository.deleteById(id);
    }

    @PutMapping("topic/{id}")
    public ResponseEntity<Object> updateTopic(@RequestBody Topic t, @PathVariable Integer id) {
        Optional<Topic> topicOptional = topicRepository.findById(id);

        if(!topicOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        t.setId(id);

        topicRepository.save(t);
        return ResponseEntity.noContent().build();
    }
}
