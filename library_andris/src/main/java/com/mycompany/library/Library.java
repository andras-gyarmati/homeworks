/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author brianelete
 */
public class Library {

    private static Library library;
    private List<Member> members;
    private List<IBorrowable> borrowables;
    private Map<Member, Map<IBorrowable, Date>[]> log;

    private Library() {
        members = new ArrayList<>();
        borrowables = new ArrayList<>();
        log = new HashMap<>();
    }

    public static Library getInstance() {
        if (null == library) {
            library = new Library();
        }
        return library;
    }

    public void newMember(String memberName, String memberId) {
        if (!isMember(memberId)) {
            members.add(new Member(memberName, memberId));
        }
    }

    public void newBook(String isbn, String title, String author) {
        if (!isBorrowable(isbn)) {
            borrowables.add(new Book(isbn, title, author));
        }
    }

    public void newMagazine(String issn, String title) {
        if (!isBorrowable(issn)) {
            borrowables.add(new Magazine(issn, title));
        }
    }

    public void borrowItem(String memberId, String borrowableId) {
        Member member = getMember(memberId);
        IBorrowable borrowable = getBorrowable(borrowableId);
        if (borrowable.getBorrowed()) {
            throw new AlreadyBorrowedException();
        } else {
            if (!log.containsKey(member)) {
                log.put(member, new HashMap[2]);
            }
            borrowable.setBorrowed(true);
            log.get(member)[0].put(borrowable, new Date());
        }
    }

    public void returnItem(String memberId, String borrowableId) {
        Member member = getMember(memberId);
        IBorrowable borrowable = getBorrowable(borrowableId);
        if (borrowable.getBorrowed()) {
            if (log.containsKey(member)) {
                borrowable.setBorrowed(false);
                log.get(member)[1].put(borrowable, new Date());
            }
            throw new MemberNotFoundException();
        } else {
            throw new NotBorrowedException();
        }
    }

    private Boolean isMember(String memberId) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                return true;
            }
        }
        return false;
    }

    private Boolean isBorrowable(String borrowableId) {
        for (IBorrowable borrowable : borrowables) {
            if (borrowable.getId().equals(borrowableId)) {
                return true;
            }
        }
        return false;
    }

    private Member getMember(String memberId) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                return member;
            }
        }
        throw new MemberNotFoundException("Error! Member not found! Id: " + memberId);
    }

    private IBorrowable getBorrowable(String borrowableId) {
        for (IBorrowable borrowable : borrowables) {
            if (borrowable.getId().equals(borrowableId)) {
                return borrowable;
            }
        }
        throw new ItemNotFoundException("Error! Item not found! Id: " + borrowableId);
    }
}
