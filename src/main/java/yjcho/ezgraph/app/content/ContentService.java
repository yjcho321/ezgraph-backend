package yjcho.ezgraph.app.content;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yjcho.ezgraph.app.dataset.DataSetRepository;

@Service
@Transactional
@AllArgsConstructor
public class ContentService {
    private final UserContentRepository userContentRepository;
    private final GuestContentRepository guestContentRepository;
    private final DataSetRepository dataSetRepository;




}
