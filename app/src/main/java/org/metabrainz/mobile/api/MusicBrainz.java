package org.metabrainz.mobile.api;

import org.metabrainz.mobile.api.data.Artist;
import org.metabrainz.mobile.api.data.ArtistSearchResult;
import org.metabrainz.mobile.api.data.Label;
import org.metabrainz.mobile.api.data.LabelSearchResult;
import org.metabrainz.mobile.api.data.Recording;
import org.metabrainz.mobile.api.data.RecordingSearchResult;
import org.metabrainz.mobile.api.data.Release;
import org.metabrainz.mobile.api.data.ReleaseGroup;
import org.metabrainz.mobile.api.data.ReleaseGroupSearchResult;
import org.metabrainz.mobile.api.data.ReleaseSearchResult;
import org.metabrainz.mobile.api.data.Tag;
import org.metabrainz.mobile.api.data.UserCollection;
import org.metabrainz.mobile.api.data.UserData;
import org.metabrainz.mobile.api.data.UserSearchResult;
import org.metabrainz.mobile.api.webservice.Entity;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface MusicBrainz {

    /*
     * Authentication
     */
    void setCredentials(String username, String password);
    boolean autenticateCredentials() throws IOException;
    
    /*
     * Search
     */
    List<ArtistSearchResult> searchArtist(String searchTerm) throws IOException;
    List<ReleaseSearchResult> searchRelease(String searchTerm) throws IOException;
    List<ReleaseGroupSearchResult> searchReleaseGroup(String searchTerm) throws IOException;
    List<LabelSearchResult> searchLabel(String searchTerm) throws IOException;
    List<RecordingSearchResult> searchRecording(String searchTerm) throws IOException;

    /*
     * Lookup
     */
    Artist lookupArtist(String mbid) throws IOException;
    Release lookupRelease(String mbid) throws IOException;
    Release lookupReleaseUsingBarcode(String barcode) throws IOException;
    Label lookupLabel(String mbid) throws IOException;
    Recording lookupRecording(String mbid) throws IOException;
    ReleaseGroup lookupReleaseGroup(String mbid) throws IOException;
    
    /*
     * User data lookup
     */
    List<Tag> lookupTags(Entity type, String mbid) throws IOException;
    float lookupRating(Entity type, String mbid) throws IOException;
    UserData lookupUserData(Entity entityType, String mbid) throws IOException;
    
    /*
     * Browse
     */
    List<ReleaseSearchResult> browseReleases(String mbid) throws IOException;

    /*
     * Submission
     */
    void submitTags(Entity entityType, String mbid, Collection<String> tags) throws IOException;
    void submitRating(Entity entityType, String mbid, int rating) throws IOException;
    void submitBarcode(String mbid, String barcode) throws IOException;
    
    /*
     * Collection
     */
    void addReleaseToCollection(String collectionMbid, String releaseMbid) throws IOException;
    void deleteReleaseFromCollection(String collectionMbid, String releaseMbid) throws IOException;
    List<UserSearchResult> lookupUserCollections() throws IOException;
    UserCollection lookupCollection(String mbid) throws IOException;

}