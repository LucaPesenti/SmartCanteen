package it.university.smartcanteen.repository;

import org.springframework.stereotype.Repository;

import it.university.smartcanteen.config.AccountingEntry;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountingRepository {

    private final List<AccountingEntry> entries = new ArrayList<>();

    public void save(AccountingEntry entry) {
        entries.add(entry);
    }

    public List<AccountingEntry> findAll() {
        return entries;
    }
}
