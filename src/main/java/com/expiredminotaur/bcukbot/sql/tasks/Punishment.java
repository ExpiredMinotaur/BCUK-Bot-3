package com.expiredminotaur.bcukbot.sql.tasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Punishment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String punishment;
    private boolean punishmentGiven = false;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getPunishment()
    {
        return punishment;
    }

    public void setPunishment(String punishment)
    {
        this.punishment = punishment;
    }

    public boolean isPunishmentGiven()
    {
        return punishmentGiven;
    }

    public void setPunishmentGiven(boolean punishmentGiven)
    {
        this.punishmentGiven = punishmentGiven;
    }
}
