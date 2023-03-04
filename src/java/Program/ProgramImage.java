/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Image.Image;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProgramImage extends Image {
    private int programId;
    
    public ProgramImage(int id, String path, int programId) {
        super(id, path);
    }
}
