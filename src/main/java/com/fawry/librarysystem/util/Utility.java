package com.fawry.librarysystem.util;

import com.fawry.librarysystem.exception.IdNotFoundException;
import com.fawry.librarysystem.repository.AuthorRepo;
import com.fawry.librarysystem.repository.BookRepo;
import com.fawry.librarysystem.repository.CategoryRepo;
import org.hibernate.Session;
public class Utility {
    private Utility() {}

    public static <T> void checkIfIdExists(T repo, Long id) throws IdNotFoundException {
        if (repo instanceof AuthorRepo authorRepo && !authorRepo.existsById(id))
            throw new IdNotFoundException("Author Not Found!!");
        if (repo instanceof BookRepo bookRepo && !bookRepo.existsById(id))
            throw new IdNotFoundException("Book Not Found!!");
        if (repo instanceof CategoryRepo categoryRepo && !categoryRepo.existsById(id))
            throw new IdNotFoundException("Category Not Found!!");
    }

}
